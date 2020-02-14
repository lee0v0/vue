import Vue from 'vue'
import Router from 'vue-router'

import PageOne from "../components/PageOne";
import PageTwo from "../components/PageTwo";
import PageThree from "../components/PageThree";
import PageFour from "../components/PageFour";
import App from "../App";
import Index from "../components/Index";

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [

    {
      path: '/',
      name: '导航1',
      component: Index,
      redirect:"/PageOne",
      children:[
        {
          path: '/PageOne',
          name: '页面1',
          component: PageOne
        },
        {
          path: '/PageTwo',
          name: '页面2',
          component: PageTwo
        }
      ]
    },

    {
      path: '/navigation2',
      name: '导航2',
      component: Index,
      children:[
        {
          path: '/PageThree',
          name: '页面3',
          component: PageThree
        },
        {
          path: '/PageFour',
          name: '页面4',
          component: PageFour
        }
      ]
    }


  ]
})
