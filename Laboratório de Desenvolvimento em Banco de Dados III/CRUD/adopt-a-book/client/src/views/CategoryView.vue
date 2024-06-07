<script setup lang="ts">
import CategoryElement, {
  type Category,
} from "@/components/CategoryElement.vue";
import FormReactiveButton from "@/components/FormReactiveButton.vue";
import { onMounted, reactive } from "vue";
import axios from "axios";

const categoryList = reactive<Category[]>([]);

const createCategory = async (category: Category) => {
  console.log(`creating: ${category.name}`);
  const response = await axios.post(
    `http://localhost:9090/category/save`,
    category
  );
};

const updateCategory = async (category: Category, oldCategory: Category) => {
  console.log(`updating: ${oldCategory.name} -> ${category.name}`);
  const response = await axios.put(
    `http://localhost:9090/category/update/${category.id}`,
    category
  );
};

const deleteCategory = async (category: Category) => {
  const removeIndex = categoryList.indexOf(category);
  categoryList.splice(removeIndex, 1);
  console.log(categoryList);
  console.log(`deleting: ${category.name}`);
  const response = await axios.delete(
    `http://localhost:9090/category/delete/${category.id}`
  );
};

const defaultCategory = reactive({
  name: "",
  bookList: [],
});

const getCategoriesFromDatabase = async () => {
  const response = await axios.get(`http://localhost:9090/category/list`);
  const rawDataList = response.data;
  for (const rawData of rawDataList) {
    const bookList = (
      await axios.get(
        `http://localhost:9090/book/list/category/${rawData.name}`
      )
    ).data;
    categoryList.push(
      Object.assign(rawData, {
        bookList: bookList,
      })
    );
  }
};

onMounted(() => {
  getCategoriesFromDatabase();
});
</script>

<template>
  <main :key="categoryList.length">
    <div>
      <ul class="flex">
        <li v-for="(category, i) in categoryList" :key="i">
          <CategoryElement :category="category">
            <FormReactiveButton :on-click="updateCategory" :object="category"
              >Edit</FormReactiveButton
            >
            <button v-on:click="deleteCategory(category)">Delete</button>
          </CategoryElement>
        </li>
      </ul>
    </div>
    <hr />
    <CategoryElement :category="defaultCategory">
      <FormReactiveButton :on-click="createCategory" :object="defaultCategory"
        >Create</FormReactiveButton
      >
    </CategoryElement>
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
