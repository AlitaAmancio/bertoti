<script setup lang="ts">
import { reactive } from "vue";

export type Category = {
  id?: number;
  name: string;
  bookList: {
    title: string;
  }[];
};

type Props = {
  category: Category;
};

const { category } = defineProps<Props>();
const reactiveCategory = reactive(category);
</script>

<template>
  <div class="card">
    <span>Nome:</span>
    <input type="text" v-model="reactiveCategory.name" />
    <slot></slot>
    <div>
      <span>Livros:</span>
      <ul v-for="book in reactiveCategory.bookList" :key="book.title">
        <li>
          {{ book.title }}
        </li>
      </ul>
    </div>
  </div>
</template>

<style>
.flex {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 16px;
}
</style>
