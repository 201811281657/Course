import Vue from "vue"
import Router from "vue-router"
import Login from './views/login.vue'
import Admin from './views/admin.vue'
import Welcome from './views/admin/welcome.vue'
import Chapter from './views/chapter.vue'
import Section from './views/section.vue'
import Student from './views/student.vue'

Vue.use(Router)
export default new Router({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [{
        path: "*",
        redirect: "/login",
    },{
        path: '/login',
        name: "login",
        component: Login
    },{
        path: '/',
        name: "admin",
        component: Admin,
        children: [{
            path: 'welcome.vue',
            name: "welcome",
            component: Welcome
        },{
            path: 'business/chapter',
            name: "business/chapter",
            component: Chapter
        },{
            path: 'business/section',
            name: "business/section",
            component: Section
        },{
            path: 'business/student',
            name: "business/student",
            component: Student
        }]
    }]
})