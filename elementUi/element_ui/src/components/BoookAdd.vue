<template>
  <div>

    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="图书名称" prop="name">
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input v-model="ruleForm.author"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        ruleForm: {
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
    methods: {

      //提交表单
      submitForm(formName) {
        const _this=this;
        this.$refs[formName].validate((valid) => {
          if (valid) {
            console.log(_this.ruleForm)
            // alert('submit!');
            this.$axios.post('http://localhost:8081/book/save',_this.ruleForm).then(res=>{
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
        this.$refs[formName].resetFields();
      }
    }
  }
</script>
