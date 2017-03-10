import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Button, Icon, Input, Table, Row, Col, Spin, notification, Modal} from 'antd';
import {Link} from 'dva/router';
import  './IndexPage.css';
import  EditDeviceIp from '../components/device/EditDeviceIp';
import EditKey from '../components/device/EditKey';
import {deleteDevice} from '../services/device';

const ButtonGroup = Button.Group;
const Search = Input.Search;

class DevicePage extends Component {

  constructor(props) {
    super(props);
    this.state = {
      visible: false,
      editKeyShow:false,
      device: null,
      selectedRowKeys: [],
      filter: ''
    }
  }

  refresh() {
    this.props.dispatch({type: "device/fetchRemote", payload: this.props.device.page});
  }

  componentWillMount() {
    this.refresh();
  }

  render() {

    const data = [];
    for (let item in this.props.device.devices.content) {
      if (this.props.device.devices.content[item].innerServer.indexOf(this.state.filter) != -1) {
        data.push(this.props.device.devices.content[item]);
        continue;
      }
      if (this.props.device.devices.content[item].outServer.indexOf(this.state.filter) != -1) {
        data.push(this.props.device.devices.content[item]);
        continue;
      }
    }

    const that = this;
    const {selectedRowKeys} = this.state;

    const doDelete = (id) => {
      deleteDevice(id).then((res)=> {
        that.refresh();
      }).fail(res => {
        notification.error({
          content: '错误',
          description: '删除失败'
        })
      });
    }

    const columns = [{
      title: '外网IP',
      dataIndex: 'outServer',
      key: 'outServer',
    }, {
      title: '内网IP',
      dataIndex: 'innerServer',
      key: 'innerServer',
    }, {
      title: '端口',
      dataIndex: 'port',
      key: 'port',
    }, {
      title: '操作系统',
      key: 'os',
      dataIndex: "os"
    }
      , {
        title: '密码/秘钥',
        key: 'authKey',
        dataIndex: "authKey",
        render: (text, record, index) => {
          if (record.authKey == null) {
            return '无';
          } else {
            return text;
          }
        }
      }
      , {
        title: '操作',
        key: 'ops',
        dataIndex: "ops",
        render: (text, record, index) => {
          return (
            <span>
          <Button onClick={()=> {
            that.setState({visible: true, device: record});
          }}>编辑</Button>

              <Button onClick={()=> {
                Modal.confirm({
                  title: '提示',
                  content: '你确定要删除吗？',
                  onOk: ()=> doDelete(record.id)
                });
              }}>删除</Button>
        </span>
          );
        }
      }
    ];

    const pagination = {
      total: this.props.device.devices.totalElements,
      pageSize: this.props.device.devices.size,
      current: this.props.device.devices.number + 1,
      defaultCurrent: 1,
      onChange: (current) => {
        that.props.dispatch({type: "device/fetchRemote", payload: current - 1});
      },
    };

    const onSelectChange = (selectedRowKeys) => {
      this.setState({selectedRowKeys: selectedRowKeys})
    }

    const rowSelection = {
      selectedRowKeys,
      onChange: onSelectChange.bind(this),
    };

    return (
      <Spin spinning={this.props.device.loading}>
        <div>
          <Row>
            <Col span="5">
              <Search placeholder="输入ip查找" style={{width: '100%'}} onInput={(e)=> {
                that.setState({filter: e.target.value})
              }}/>
            </Col>
            <Col span="6"><ButtonGroup>
              <Button title="添加" onClick={()=>location.href = "#/add-device"}><Icon type="plus"/></Button>
              <Button title="批量修改秘钥" onClick={()=>{
                this.setState({editKeyShow:true});
              }} disabled={selectedRowKeys.length == 0}><Icon type="edit"/></Button>
            </ButtonGroup></Col>
          </Row>
          <Table columns={columns} rowSelection={rowSelection} dataSource={data}
                 pagination={pagination}> </Table>
        </div>
        <EditDeviceIp visible={this.state.visible} device={this.state.device}
                      dispatch={this.props.dispatch} that={that}></EditDeviceIp>
        <EditKey node={that} selectedRowKeys={selectedRowKeys} editKeyShow={this.state.editKeyShow}></EditKey>
      </Spin>
    );
  }
}

DevicePage.propTypes = {};

function mapStateToProps({device}) {
  return {device};
}

export default connect(mapStateToProps)(DevicePage);

