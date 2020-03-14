import Vue from 'vue'
import Router from 'vue-router'
import index from '../views/index'
import FormGen from '../components/FormGen'
import FormMake from '../components/FormMake'
import FormList from "@/components/FormList";

Vue.use(Router)

const router = new Router({
    routes: [
        {
            path: '/',
            name: 'Index',
            component: index,
            children:[
                {
                    path: '/formmake',
                    name: 'FormMake',
                    component: FormMake
                },
                {
                    path: '/formgen',
                    name: 'FormGen',
                    component: FormGen
                },
                {
                    path: '/formlist',
                    name: 'formlist',
                    component: FormList
                }
            ]
        }
    ]
})

export default router