<template>
    <div>
        <table>
            <thead>
            <tr>
                <th>学生编号</th>
                <th>姓名</th>
                <th>年龄</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="student in students">
                <td>{{student.id}}</td>
                <td>{{student.name}}</td>
                <td>{{student.age}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>
<script>
    export default {
        components: 'Student',
        name: 'student',
        data: function () {
            return {
                student: {},
                students: []
            }

        },
        mounted() {
            // this.$parent.activeSidebar("business-chapter-sidebar")
            let _this = this;
            _this.list();
        },
        methods: {
            list(){
                let _this = this;
                _this.$ajax.get('http://127.0.0.1:9000/business/admin/student/list').then((response)=>{
                    _this.students = response.data;
                    console.log("nihao+"+students)
                })

            }
        }



    }
</script>