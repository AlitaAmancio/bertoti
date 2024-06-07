<script setup lang="ts">
import { reactive } from "vue";

export type Author = {
  id?: number;
  name: string;
  biography: string;
  birthdate: string;
  bookList: {
    title: string;
  }[];
};

type Props = {
  author: Author;
};

const { author } = defineProps<Props>();
const reactiveAuthor = reactive(author);
</script>

<template>
  <div class="card">
    <span>Nome:</span>
    <input type="text" v-model="reactiveAuthor.name" />
    <span>Biografia:</span>
    <textarea v-model="reactiveAuthor.biography"></textarea>
    <span>Data Nascimento:</span>
    <input type="date" v-model="reactiveAuthor.birthdate" />
    <slot></slot>
    <div>
      <span>Livros:</span>
      <ul v-for="book in reactiveAuthor.bookList" :key="book.title">
        <li>
          {{ book.title }}
        </li>
      </ul>
    </div>
  </div>
</template>

<style scoped>
li {
  display: flex;
  flex-direction: column;
}
.wrapper {
  height: 2rem;
  display: flex;
  gap: 16px;
  align-items: center;
}
.card {
  background-color: aliceblue;
  padding: 2rem;
  border-radius: 25px;
}
</style>
