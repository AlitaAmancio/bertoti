<script setup lang="ts">
import { computed, reactive, ref } from "vue";
export type Props = {
  object: any;
  onClick: (object: any, oldObject?: any) => Promise<void> | void;
};

const { object, onClick } = defineProps<Props>();
const prev = ref(JSON.stringify(object));

const changed = computed(() => {
  return JSON.stringify(object) === prev.value;
});

const onClickGlobal = async () => {
  await onClick(object, JSON.parse(prev.value));

  prev.value = JSON.stringify(object);
};
</script>

<template>
  <button :disabled="changed" v-on:click="onClickGlobal()">
    <slot></slot>
  </button>
</template>
<style scoped></style>
