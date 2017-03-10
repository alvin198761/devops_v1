import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Button, Icon, Input, Row, Col, Form, Modal,Select,notification} from 'antd';
import {editKey} from '../../services/device';

const FormItem = Form.Item;
const Option = Select.Option;

const formItemLayout = {
  labelCol: {span: 3},
  wrapperCol: {span: 20},
};

class EditKey extends Component {

  constructor(props){
    super(props)
  }

  componentWillMount(){
    this.props.dispatch({type:"authkey/fetchRemote"});
  }

  render(){
    const okClick = (e)=>{
      this.props.form.validateFields((err,values) => {
        if (err) {
          return;
        }
        values.devices = this.props.selectedRowKeys;
        editKey(values).then(res => {
          notification.success({
            content:'提示',
            description:'修改成功'
          });
        }).fail(res => {
          notification.error({
            content:'错误',
            description:'修改失败'
          });
        });
      })
    }

    const cancelClick =(e) => {
      this.props.node.setState({editKeyShow:false});
    }

    const {getFieldDecorator, getFieldValue} =  this.props.form;
    return (
      <Modal visible={this.props.editKeyShow} title={"批量修改Key"}
        onOk={okClick} onCancel={cancelClick} >
        <Form>
          <FormItem label={"秘钥："} {...formItemLayout}>
            {getFieldDecorator("id",{ rules: [{required: true, message: '请选择Key'}]}) ( <Select>
              {
                this.props.authkey.keys.map(item => {
                  <Option value={item.id}>{item.name}</Option>
                })
              }
            </Select>)}
            </FormItem>
        </Form>
      </Modal>
    )
  }

}
EditKey.propTypes ={};

function mapStateToProps({authkey}){
  return {authkey};
}

export  default connect(mapStateToProps)( Form.create()(EditKey));
