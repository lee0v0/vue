<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%">
      <el-table-column
        fixed
        prop="id"
        label="编号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="name"
        label="图书名称"
        width="120">
      </el-table-column>
      <el-table-column
        prop="author"
        label="作者"
        width="120">
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="del(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="pagesize"
      :total="total"
      @current-change="page"
    >
    </el-pagination>
  </div>
</template>

<script>
  export default {
    inject:["reload"],
    name:"PageOne",
    methods: {
      edit(row) {
        console.log(row.id);
        this.$router.push({
          path:"/BookUpdate",
          query:{
            id:row.id
          }
        });
      },
      del(row){
        const _this=this;
        this.$axios.get("http://localhost:8081/book/del/"+row.id)
          .then(resp => {
            // _this.$router.push("/BookManagement")
            // if(resp.data=="success"){
            //   // _this.$message({
            //   //   showClose: true,
            //   //   message: '添加成功'
            //   // });
            //
            // }else {
            //   _this.$message({
            //     showClose: true,
            //     message: '添加失败',
            //     type: 'error'
            //   });
            // }
            _this.reload();
          }).catch(err => {

          console.log(err);

        })
      },
      page(currenPage){
        const _this=this;
        this.$axios.get("http://localhost:8081/book/findAll/"+(currenPage-1)+"/"+this.pagesize)
          .then(resp => {
            _this.tableData=resp.data.content;
            _this.pagesize=resp.data.size;
            _this.total=resp.data.totalElements;
            console.log(resp);

          }).catch(err => {

          console.log(err);

        })
      }


    },
    created() {
      const _this=this;
      this.$axios.get("http://localhost:8081/book/findAll/0/3")
        .then(resp => {
          _this.tableData=resp.data.content;
          _this.pagesize=resp.data.size;
          _this.total=resp.data.totalElements;
          console.log(resp);

        }).catch(err => {

        console.log(err);

      })
    },
    data() {
      return {
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-04',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1517 弄',
          zip: 200333
        }, {
          date: '2016-05-01',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1519 弄',
          zip: 200333
        }, {
          date: '2016-05-03',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1516 弄',
          zip: 200333
        }]
      }
    }
  }
</script>
