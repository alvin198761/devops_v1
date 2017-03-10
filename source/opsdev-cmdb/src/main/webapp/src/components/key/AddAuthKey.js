import React from 'react';
import {Form, Input, Button, Select, Modal, Spin,InputNumber,notification} from 'antd';
import  {checkKeyNameExist} from '../../utils/ValidateUtil';
import  {addAuthKey} from '../../services/authkey';
import  {browserHistory} from 'dva/router';

const FormItem = Form.Item;
const Option = Select.Option;

const formItemLayout = {
  labelCol: {span: 3},
  wrapperCol: {span: 7},
};

const AddAuthKey = (props) => {
  const {getFieldDecorator, getFieldValue} =  props.form;

  const doSubmit = (e) => {
    e.preventDefault();
    props.form.validateFields((err, values) => {
      if (err) {
        return;
      }
      addAuthKey(values).then(res=> {
        notification.success({
          content:'提示',
          description:'添加成功'
        });
      }).fail(res =>{
        notification.error({
          content:'错误',
          description:'添加成功'
        })
      });
    });
  };

  const type = getFieldValue("type") ? getFieldValue("type") : "1";

  return (
    <Spin spinning={false}>
      <Form onSubmit={doSubmit.bind(this)}>
        <FormItem label="秘钥名称:" {...formItemLayout}>
          { getFieldDecorator('name', {
            rules: [{required: true, message: '请输入秘钥名'}
            ,{validator:checkKeyNameExist}]
          })(<Input  />)}
        </FormItem>
        <FormItem label="类型:" {...formItemLayout}>
          { getFieldDecorator('type', {initialValue: "1"})(<Select>
            <Option value={"1"}>密码</Option>
            <Option value={"2"}>秘钥</Option>
          </Select>)}
        </FormItem>
        <FormItem label="用户名:" {...formItemLayout}>
          { getFieldDecorator('user', {
            rules: [{required: true, message: '请输入用户名'}]
          })(<Input  />)}
        </FormItem>
        <FormItem label="密码/秘钥:" {...formItemLayout}>
          { getFieldDecorator('content', {
            rules: [{required: true, message: '请输入密码/秘钥'}]
          })(<Input type="textarea" />)}
        </FormItem>
        <FormItem wrapperCol={{span: 12, offset: 3}}>
          <Button type="primary" htmlType="submit">确定</Button>
        </FormItem>
      </Form>
    </Spin>
  );
};

AddAuthKey.propTypes = {};

export default Form.create()(AddAuthKey);
