<script setup lang="ts">
import AuthorElement, { type Author } from "@/components/AuthorElement.vue";
import FormReactiveButton from "@/components/FormReactiveButton.vue";
import { reactive, onMounted } from "vue";
import axios from "axios";

const authorList = reactive<Author[]>([]);

const createAuthor = async (author: Author) => {
  console.log(`creating: ${author.name}`);
  const response = await axios.post(
    `http://localhost:9090/author/save`,
    author
  );
};

const updateAuthor = async (author: Author, oldAuthor: Author) => {
  console.log(`updating: ${oldAuthor.name} -> ${author.name}`);
  const response = await axios.put(
    `http://localhost:9090/author/update/${author.id}`,
    author
  );
};

const deleteAuthor = async (author: Author) => {
  const removeIndex = authorList.indexOf(author);
  authorList.splice(removeIndex, 1);
  console.log(`deleting: ${author.name}`);
  const response = await axios.delete(
    `http://localhost:9090/author/delete/${author.id}`
  );
};

const defaultAuthor = reactive<Author>({
  name: "",
  biography: "",
  birthdate: "",
  bookList: [],
});

const getAuthorsFromDatabase = async () => {
  const response = await axios.get("http://localhost:9090/author/list");
  const rawDataList = response.data;
  for (const rawData of rawDataList) {
    const bookList = (
      await axios.get(`http://localhost:9090/book/list/author/${rawData.name}`)
    ).data;
    authorList.push(
      Object.assign(rawData, {
        bookList: bookList,
        birthdate: rawData.birthdate.split("T")[0],
      })
    );
  }
};

onMounted(() => {
  getAuthorsFromDatabase();
});
</script>

<template>
  <main :key="authorList.length">
    <div>
      <ul class="flex" :key="authorList.length">
        <li v-for="(author, i) in authorList" :key="i">
          <AuthorElement :author="author">
            <FormReactiveButton :on-click="updateAuthor" :object="author"
              >Edit</FormReactiveButton
            >
            <button v-on:click="deleteAuthor(author)">Delete</button>
          </AuthorElement>
        </li>
      </ul>
    </div>
    <hr />
    <AuthorElement :author="defaultAuthor">
      <FormReactiveButton :on-click="createAuthor" :object="defaultAuthor"
        >Create</FormReactiveButton
      >
    </AuthorElement>
  </main>
</template>

<style scoped>
.flex {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 16px;
}
.distant {
  padding: 20px 0;
}
</style>
