/**
 * Created by tangzhichao on 2016/12/23.
 */
import React, {Component, PropTypes} from 'react';
import {Table, Button, Icon, Row, Col, Input, Form, Select} from 'antd';
import {connect} from 'dva';
import {Link} from 'dva/router';

const FormItem = Form.Item;
const Option = Select.Option;

class AddAppPage extends Component {

  constructor(porps) {
    super(porps);
  }

  handleSubmit(e) {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
      }
    });
  }

  handleSelectChange(value) {
    console.log(value);
    // this.props.form.setFieldsValue({
    //   note: `Hi, ${value === 'male' ? 'man' : 'lady'}!`,
    // });
  }

  render() {
    const {getFieldDecorator} = this.props.form;
    return (
      <div>
        <Form onSubmit={this.handleSubmit}>
          <Row>
            <Col span="10">
              <FormItem
                label="APP 名称"
                labelCol={{ span: 4}}
                wrapperCol={{ span: 19 }}
              >
                {getFieldDecorator('name', {
                  rules: [{required: true, message: 'Please input app name!'}],
                })(
                  <Input placeholder="输入 App 名称"/>
                )}
              </FormItem>
            </Col> <Col span="10">
            <FormItem
              label="应用地址"
              labelCol={{ span: 8 }}
              wrapperCol={{ span: 15 }}
            >
              {getFieldDecorator('url', {
                rules: [{required: true, message: 'Please input app url!'}],
              })(
                <Input placeholder="示例：http://192.168.0.100:8080/test"/>
              )}
            </FormItem></Col>
          </Row>
          <Row>
            <Col span="10">
              <FormItem
                label="描述"
                labelCol={{ span: 4 }}
                wrapperCol={{ span: 20}}
              >
                {getFieldDecorator('description', {
                  rules: [{required: true, message: 'Please input your description!'}]
                })(
                  <Input type="textarea" placeholder="请输入应用描述信息"/>
                )}
              </FormItem>
            </Col>
          </Row>
          <Row>
            <Col span="10">
              <FormItem
                label="图标"
                labelCol={{ span: 4 }}
                wrapperCol={{ span: 20}}
              >
                <Icon type="credit-card"/>
              </FormItem>
            </Col>
          </Row>
          <Row>
            <Col>
              <ul>
                <li> <Icon type="credit-card"/></li>
              </ul>
            </Col>
          </Row>
          <Row>
            <Col span="10">
              <FormItem wrapperCol={{ span: 4, offset: 4 }}>
                <Button type="primary" htmlType="submit">添加</Button>
              </FormItem>
            </Col>
          </Row>
        </Form>
      </div>
    )
  }

}

AddAppPage.protoTypes = {}

AddAppPage = Form.create({})(AddAppPage)

function mapStateToProps({appstore}) {
  return {appstore};
}
export default connect(mapStateToProps)(AddAppPage);
