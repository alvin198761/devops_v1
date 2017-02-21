import React, {Component, PropTypes} from 'react';
import {Card,Form, Icon, Input, Button, Checkbox,message} from 'antd';
import {connect} from 'dva';
import {Link} from 'dva/router';
import md5 from 'js-md5';
import './login.css'

const FormItem = Form.Item;

class LoginPage extends Component {


  handleSubmit(e){
    e.preventDefault();
    const _this = this;
    _this.props.form.validateFields((err, values) => {
      if (err) {
        return ;
      }
      var hash = md5.create();
      hash.update(values.j_password);
      _this.props.form.setFieldsValue({j_password:hash.hex()});
      document.getElementById("loginForm").submit();
    });
  }

  render(){
    console.log("login page")
    const { getFieldDecorator } = this.props.form;
    return (
      <div className="logo-card">
        <Card title="Login" bordered={true} >
          <Form onSubmit={this.handleSubmit.bind(this)} className="login-form" name="loginForm" id="loginForm" action="j_spring_security_check" method="post" >
            <FormItem>
              {getFieldDecorator('j_username', {
                rules: [{ required: true, message: 'Please input your username!' }],
                initialValue:this.props.main.form.user
              })(
                <Input name="j_username" addonBefore={<Icon type="user" />} placeholder="Username" />
              )}
            </FormItem>
            <FormItem>
              {getFieldDecorator('j_password', {
                rules: [{ required: true, message: 'Please input your Password!' }],
                initialValue:this.props.main.form.password
              })(
                <Input  name="j_password"  addonBefore={<Icon type="lock" />} type="password" placeholder="Password"/>
              )}
            </FormItem>
            <FormItem>
              {getFieldDecorator('remember', {
                valuePropName: 'checked',
                initialValue: this.props.main.form.remember,
              })(
                <Checkbox>Remember me</Checkbox>
              )}
              <a className="login-form-forgot">Forgot password</a>
              <Button type="primary" htmlType="submit" className="login-form-button">
                Log in
              </Button>
              Or <a>register now!</a>
            </FormItem>
          </Form>
        </Card>
      </div>
    );
  }
}

LoginPage.protoTypes ={}
LoginPage =Form.create({})(LoginPage);
function mapStateToProps({main}) {
  return {main};
}
export default connect(mapStateToProps)(LoginPage);
