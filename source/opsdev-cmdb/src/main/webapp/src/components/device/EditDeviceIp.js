import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Modal, Form, Input, notification} from 'antd';
import  {checkIpValidator} from  '../../utils/ValidateUtil';
import {editIp} from '../../services/device';

const FormItem = Form.Item;

const formItemLayout = {
  labelCol: {span: 6},
  wrapperCol: {span: 18},
};

const EditDeviceIp = (props) => {

  const {getFieldDecorator, getFieldValue ,setFieldsValue} =  props.form;

  const handleOk = ()=> {
    props.form.validateFields((err, values) => {
      if (err) {
        return;
      }
      values.id = props.device.id;
      editIp(values).then((res)=> {
        notification.success({
          content: "提示",
          description: "修改成功"
        })
        props.that.props.dispatch({type: "device/fetchRemote", payload:  props.that.props.device.page});
      }).fail((res)=> {
        notification.error({
          content: "错误",
          description: "修改失败"
        })
      });
      props.that.setState({visible: false});
    })
  };

  const handleCancel = () => {
    props.that.setState({visible: false});
  }


  return (
    <Modal title="编辑 IP" visible={props.visible} onOk={handleOk} onCancel={handleCancel}>
      <Form  >
        <FormItem label="内网 IP :" {...formItemLayout}>
          {getFieldDecorator('innerIp', {
            rules: [{required: true, message: '内网 Ip 不能为空'}
              , {validator: checkIpValidator}],
            initialValue:props.device&&props.device.innerServer
          })(
            <Input placeholder="请输入内网IP"/>
          )}
        </FormItem>
        <FormItem label="外网 IP :"  {...formItemLayout}>
          {getFieldDecorator('outerIp', {
            rules: [{required: true, message: '外网 Ip 不能为空'}, {validator: checkIpValidator}],
            initialValue:props.device&&props.device.outServer
          })(
            <Input placeholder="请输入外网IP"/>
          )}
        </FormItem>
      </Form>
    </Modal>
  );
};

EditDeviceIp.propTypes = {};

export default Form.create()(EditDeviceIp);
