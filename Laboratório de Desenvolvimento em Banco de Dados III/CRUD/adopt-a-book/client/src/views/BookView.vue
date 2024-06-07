<script setup lang="ts">
import type { Author } from "@/components/AuthorElement.vue";
import BookElement, { type Book } from "@/components/BookElement.vue";
import type { Category } from "@/components/CategoryElement.vue";
import FormReactiveButton from "@/components/FormReactiveButton.vue";
import axios from "axios";
import { reactive, onMounted } from "vue";

const bookList = reactive<Book[]>([]);

const authorList = reactive<Author[]>([]);

const categoryList = reactive<Category[]>([]);

const createBook = async (book: Book) => {
  console.log(`creating: ${book.title}`);
  const response = await axios.post(`http://localhost:9090/book/save`, book);
};

const updateBook = async (book: Book, oldBook: Book) => {
  console.log(`updating: ${oldBook.title} -> ${book.title}`);
  const response = await axios.put(
    `http://localhost:9090/book/update/${book.id}`,
    book
  );
};

const deleteBook = async (book: Book) => {
  const removeIndex = bookList.indexOf(book);
  bookList.splice(removeIndex, 1);
  console.log(`deleting: ${book.title}`);
  const response = await axios.delete(
    `http://localhost:9090/book/delete/${book.id}`
  );
};

const populateAuthor = async () => {
  const response = await axios.get("http://localhost:9090/author/list");
  const rawDataList = response.data;
  authorList.push(
    ...rawDataList.map((rawData: any) =>
      Object.assign({}, rawData, {
        bookList: [],
        birthdate: rawData.birthdate.split("T")[0],
      })
    )
  );
};

const populateCategory = async () => {
  const response = await axios.get(`http://localhost:9090/category/list`);
  const rawDataList = response.data;
  categoryList.push(
    ...rawDataList.map((rawData: any) =>
      Object.assign({}, rawData, {
        bookList: [],
      })
    )
  );
};

const getBooksFromDatabase = async () => {
  const response = await axios.get("http://localhost:9090/book/list");
  const rawDataList = response.data;
  bookList.push(
    ...rawDataList.map((rawData: any) => Object.assign({}, rawData))
  );
};

onMounted(async () => {
  await populateAuthor();
  await populateCategory();
  await getBooksFromDatabase();
});

const defaultBook = reactive({
  title: "",
  description: "",
  coverType: "",
  publicationDate: "",
  author: [],
  categories: [],
});
</script>

<template>
  <main>
    <ul>
      <li v-for="(book, i) in bookList" :key="i">
        <BookElement
          :book="book"
          :author-list="authorList"
          :category-list="categoryList"
        >
          <FormReactiveButton :on-click="updateBook" :object="book"
            >Edit</FormReactiveButton
          >
          <button v-on:click="deleteBook(book)">Delete</button>
        </BookElement>
      </li>
    </ul>
    <hr />
    <BookElement
      :book="defaultBook"
      :author-list="authorList"
      :category-list="categoryList"
    >
      <FormReactiveButton :on-click="createBook" :object="defaultBook"
        >Create</FormReactiveButton
      >
    </BookElement>
  </main>
</template>

<style scoped>
.distant {
  padding: 20px 0;
}
ul {
  display: flex;
  gap: 32px;
}
li {
  display: flex;
  flex-direction: column;
}
.wrapper {
  display: flex;
  flex-direction: column;
  gap: 16px;
}
.book-container {
  display: grid;
  gap: 16px;
  grid-template-columns: repeat(3, min-content);
  align-items: center;
  text-align: right;
}

textarea {
  resize: none;
}
</style>
