import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
// import hello from "@/components/hello";
import Book from "../components/Book"

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    // {
    //   path: "/hello",
    //   name: "hello",
    //   component: hello
    // },
    {
      path:'/',
      component:Book
    }
  ]
})
