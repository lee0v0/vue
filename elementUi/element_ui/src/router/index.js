import Vue from 'vue'
import Router from 'vue-router'

import BookMangement from "../components/BookMangement";
import BoookAdd from "../components/BoookAdd";
import App from "../App";
import Index from "../components/Index";
import BookUpdate from "../components/BookUpdate";
Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [

    {
      path: '/',
      name: '图书管理',
      component: Index,
      redirect:"/BookManagement",
      children:[
        {
          path: '/BookManagement',
          name: '管理图书',
          component: BookMangement
        },
        {
          path: '/BookAdd',
          name: '添加图书',
          component: BoookAdd
        },
        {
          path: '/BookUpdate',
          name: '修改图书',
          component: BookUpdate
        }
      ]
    }

    // {
    //   path: '/navigation2',
    //   name: '导航2',
    //   component: Index,
    //   children:[
    //     {
    //       path: '/PageThree',
    //       name: '页面3',
    //       component: PageThree
    //     },
    //     {
    //       path: '/PageFour',
    //       name: '页面4',
    //       component: PageFour
    //     }
    //   ]
    // }


  ]
})
