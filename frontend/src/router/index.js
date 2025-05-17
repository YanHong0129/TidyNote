import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Hello from '../views/Helloworld.vue'
import AddNoteForm from '../views/AddNoteForm.vue'

const routes = [
    {path: '/',name: 'Home',component: Home}, //default page
    {path: '/hello',name: 'Hello',component: Hello},
    {path: '/add',name: 'AddNoteForm',component: AddNoteForm, meta:{view:'add'}},
    {path: '/edit/:noteID',name: 'EditNoteForm',component: AddNoteForm, meta:{view:'edit'}},
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router