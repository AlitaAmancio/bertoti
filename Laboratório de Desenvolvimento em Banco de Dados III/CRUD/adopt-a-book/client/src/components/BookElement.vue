<script setup lang="ts">
import { reactive, ref } from "vue";
import type { Author } from "./AuthorElement.vue";
import type { Category } from "./CategoryElement.vue";

type OmitAuthor = Omit<Author, "bookList">;
type OmitCategory = Omit<Category, "bookList">;
export type Book = {
  id?: number;
  title: string;
  description: string;
  coverType: string;
  publicationDate: string;
  author: OmitAuthor[];
  categories: OmitCategory[];
};

export type Props = {
  book: Book;
  authorList: Author[];
  categoryList: Category[];
};

const { book, authorList, categoryList } = defineProps<Props>();
const reactiveBook = reactive(book);

const newAuthor = defineModel("newAuthor", { default: "" });
const addAuthor = () => {
  if (newAuthor.value === "") return;
  const id = +newAuthor.value.split(" ")[0];
  reactiveBook.author.push(
    authorList.find((author) => author.id === id) as Author
  );
  newAuthor.value = "";
};
const removeAuthor = (author: OmitAuthor) => {
  const authorIndex = reactiveBook.author.indexOf(author);
  reactiveBook.author.splice(authorIndex, 1);
};

const newCategory = defineModel("newCategory", { default: "" });
const addCategory = () => {
  if (newCategory.value === "") return;
  const id = +newCategory.value.split(" ")[0];
  reactiveBook.categories.push(
    categoryList.find((category) => category.id === id) as Category
  );
  newCategory.value = "";
};
const removeCategory = (category: OmitCategory) => {
  const categoryIndex = reactiveBook.categories.indexOf(category);
  reactiveBook.categories.splice(categoryIndex, 1);
};
</script>

<template>
  <div class="card">
    <div>
      <span>Nome:</span>
      <input type="text" v-model="reactiveBook.title" />
    </div>
    <div>
      <span>Descrição:</span>
      <textarea v-model="reactiveBook.description"></textarea>
    </div>
    <div>
      <span>Tipo de capa: </span>
      <select v-model="reactiveBook.coverType">
        <option>Capa dura</option>
        <option>Capa papel</option>
      </select>
    </div>
    <div>
      <span>Data de Publicação</span>
      <input type="date" v-model="reactiveBook.publicationDate" />
    </div>
    <div>
      <h2>Autores:</h2>
      <ul>
        <li v-for="author in reactiveBook.author">
          <span>{{ author.name }}</span>
          <button v-on:click="removeAuthor(author)">Remove</button>
        </li>
        <li>
          <select v-model="newAuthor">
            <template v-for="(author, i) in authorList" :key="i">
              <option
                v-if="
                  !reactiveBook.author.find(
                    (_author) => _author.name === author.name
                  )
                "
              >
                {{ author.id }} {{ author.name }}
              </option>
            </template>
          </select>
          <button v-on:click="addAuthor()">Add</button>
        </li>
      </ul>
    </div>
    <div>
      <h2>Categorias:</h2>
      <ul>
        <li v-for="category in reactiveBook.categories">
          <span>{{ category.name }}</span>
          <button v-on:click="removeCategory(category)">Remove</button>
        </li>
        <li>
          <select v-model="newCategory">
            <template v-for="(category, i) in categoryList" :key="i">
              <option
                v-if="
                  !reactiveBook.categories.find(
                    (_category) => _category.name === category.name
                  )
                "
              >
                {{ category.id }} {{ category.name }}
              </option>
            </template>
          </select>
          <button v-on:click="addCategory()">Add</button>
        </li>
      </ul>
    </div>

    <slot></slot>
  </div>
</template>

<style scoped>
.card {
  background-color: aliceblue;
  padding: 2rem;
  border-radius: 25px;
}
</style>
