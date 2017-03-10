import React from 'react';
import {Form, Input, Button, Select, Modal, Spin, InputNumber, notification, Row, Col} from 'antd';
import  {checkIpValidator} from '../../utils/ValidateUtil';
import  {addDevice} from '../../services/device';
import  {browserHistory} from 'dva/router';

const FormItem = Form.Item;
const Option = Select.Option;

const rowFormItemLayout = {
  labelCol: {span: 6},
  wrapperCol: {span: 14},
}

const AddDevice = (props) => {
  const {getFieldDecorator, getFieldValue} =  props.form;

  const doSubmit = (e) => {
    e.preventDefault();
    props.form.validateFields((err, values) => {
      if (err) {
        return;
      }
      addDevice(values).then((data)=> {
        notification["success"]({
          message: "提示",
          description: "添加成功"
        });
        location.href = "#/device";
      }).fail(data => {
        Modal.error({
          title: "提示",
          content: "添加失败"
        });
      });
    });
  };

  const type = getFieldValue("type") ? getFieldValue("type") : "0";

  return (
    <Spin spinning={false}>
      <Form onSubmit={doSubmit.bind(this)}>
        <Row >
          <Col span={12}> <FormItem label="设备类型:" {...rowFormItemLayout}>
            { getFieldDecorator('type', {initialValue: "0"})(<Select>
              <Option value={"0"}>服务器</Option>
              <Option value={"1"} disabled={true}>存储</Option>
              <Option value={"2"} disabled={true}>数据库</Option>
            </Select>)}
          </FormItem></Col>
        </Row>
        <Row>
          <Col span={12}><FormItem label="外网外IP:" {...rowFormItemLayout}>
            { getFieldDecorator('outerIp', {
              rules: [{required: true, message: '请输入外网Ip'}, {validator: checkIpValidator}]
            })(<Input  />)}
          </FormItem></Col>
          <Col span={12}> <FormItem label="内外IP:" {...rowFormItemLayout}>
            { getFieldDecorator('innerIp', {
              rules: [{required: true, message: '请输入内网Ip'}, {validator: checkIpValidator}]
            })(<Input  />)}
          </FormItem></Col>
        </Row>
        <Row>
          <Col span={12}>
            <FormItem label="端口:" {...rowFormItemLayout}>
              { getFieldDecorator('port', {initialValue: 22})(<InputNumber min={1}/>)}
            </FormItem>
          </Col>
          <Col span={12}>
            {type == "0" &&
            <FormItem label="操作系统类型:" {...rowFormItemLayout}>
              { getFieldDecorator("osType", {initialValue: "0"})(
                <Select>
                  <Option value={"0"}>Linux</Option>
                  <Option value={"1"} disabled={true}>Windows</Option>
                </Select>
              )}
            </FormItem>}
          </Col>
        </Row>
        <Row>
          <Col span={12}>  {type == "0" && < FormItem label="操作系统版本:" {...rowFormItemLayout}>
            { getFieldDecorator("version", {initialValue: "0"})(
              <Select>
                <Option value={"0"}>Centos 6.5</Option>
                <Option value={"1"}>Centos 6.0</Option>
                <Option value={"2"}>Centos 7.1</Option>
              </Select>
            )}
          </FormItem>}</Col>
          <Col span={12}>
            {type == "0" && <FormItem label="操作系统架构:" {...rowFormItemLayout}>
              { getFieldDecorator("arch", {initialValue: "X86"})(
                <Select>
                  <Option value={"X86"}>X86</Option>
                  <Option value={"X86_64"} disabled={true}>X86_64</Option>
                </Select>
              )}
            </FormItem> }
          </Col>
        </Row>
        <FormItem wrapperCol={{span: 12, offset: 3}}>
          <Button type="primary" htmlType="submit">确定</Button>
        </FormItem>
      </Form>
    </Spin>
  );
};

AddDevice.propTypes = {};

export default Form.create()(AddDevice);
