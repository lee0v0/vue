<template>
    <div>
      <table>
        <tr>
          <td>编号</td>
          <td>图书名称</td>
          <td>作者</td>
        </tr>
        <tr v-for="item in books">
          <td>{{item.id}}</td>
          <td>{{item.name}}</td>
          <td>{{item.author}}</td>
        </tr>
      </table>
      <p>{{msg}}</p>
    </div>
</template>

<script>
    export default {
        name: "Book",
      data() {
        return {
          msg: "hello vue",
          books: [
            {
              id: 1,
              name: 'java',
              author: '列hi是'
            },
            {
              id: 2,
              name: 'java',
              author: '列hi是'
            },
            {
              id: 3,
              name: 'java',
              author: '列hi是'
            }
          ]

        }
      },
      created(){
          const _this=this;
        this.$axios.get('http://localhost:8081/book/findAll')
          .then(function (response) {
            _this.books=response.data;
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
      }

    }
</script>

<style scoped>

</style>
