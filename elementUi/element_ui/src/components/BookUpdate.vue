<template>
  <div>

    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="图书编号" prop="id">
        <el-input v-model="ruleForm.id" readonly></el-input>
      </el-form-item>
      <el-form-item label="图书名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input v-model="ruleForm.author"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">更改</el-button>
        <el-button @click="resetForm('ruleForm')">重新修改</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    name:'BookUpdate',
    data() {
      return {
        ruleForm: {
          id:'',
          name: '',
          author:''
        },
        rules: {
          name: [
            { required: true, message: '请输入图书名称', trigger: 'blur' },
            { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
          ],
          author: [
            { required: true, message: '请输入作者名称', trigger: 'blur' },
            { min: 2, max: 50, message: '长度在 2 到 50 个字符', trigger: 'blur' }
          ]
        }
      };
    },
    created() {
      const _this=this;
      // alert(this.$route.query.id);
      this.$axios.get("http://localhost:8081/book/findById/"+this.$route.query.id)
      .then(function (resp) {
          _this.ruleForm=resp.data;
      })
    },
    methods: {

      //提交表单
      submitForm(formName) {
        const _this=this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(_this.ruleForm)
            // alert('submit!');
            this.$axios.post('http://localhost:8081/book/update',_this.ruleForm).then(res=>{
              console.log('res=>',res);
              if(res.data=="success"){
                // _this.$message({
                //   showClose: true,
                //   message: '添加成功'
                // });
                _this.$router.push("/BookManagement")
              }else {
                _this.$message({
                  showClose: true,
                  message: '添加失败',
                  type: 'error'
                });

              }
            })
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        // this.$refs[formName].resetFields();
        const _this=this;
        // alert(this.$route.query.id);
        this.$axios.get("http://localhost:8081/book/findById/"+this.$route.query.id)
          .then(function (resp) {
            _this.ruleForm=resp.data;
          })
      }
    }
  }
</script>
