import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes: [
		{
			path: '/',
			name: 'home',
			component: () => import('../views/HomeView.vue')
		},
		{
			path: '/author',
			name: 'author',
			component: () => import('../views/AuthorView.vue')
		},
		{
			path: '/category',
			name: 'category',
			component: () => import('../views/CategoryView.vue')
		},
		{
			path: '/book',
			name: 'book',
			component: () => import('../views/BookView.vue')
		}
	]
})

export default router
