/**
 * Created by tangzhichao on 2016/12/22.
 */
import React, {Component, PropTypes} from 'react';
import {Table,Button, Icon,Row,Col,Input} from 'antd';
import {connect} from 'dva';
import {Link} from 'dva/router';

const ButtonGroup = Button.Group;

class AppPage extends Component {
  constructor(props) {
    super(props);
  }

  componentWillMount() {
    this.props.dispatch({
      type: 'appstore/fetchList', payload: {
        page: 0
      }
    })
  }

  render() {

    const columns = [{
      title: '名称',
      dataIndex: 'title',
      render: (text, record) => <span><Icon type={record.icon}/>&nbsp; {record.title}</span>

    }, {
      title: '地址',
      dataIndex: 'url',
    }, {
      title: '描述',
      dataIndex: 'description',
    }];

    let data = [];
    let paginationCfg = {};
    const _this = this;
    if (this.props.appstore.list) {
      data = this.props.appstore.list.content;
      paginationCfg = {
        total: this.props.appstore.list.totalElements,
        current: this.props.appstore.list.number + 1,
        pageSize: this.props.appstore.list.size,
        onChange: function (page) {
          _this.props.dispatch({
            type: 'appstore/fetchList', payload: {
              page: page - 1
            }
          })
        }
      }
    }

    const rowSelection = {
      onChange: (selectedRowKeys, selectedRows) => {
        console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
      },
      onSelect: (record, selected, selectedRows) => {
        console.log(record, selected, selectedRows);
      },
      onSelectAll: (selected, selectedRows, changeRows) => {
        console.log(selected, selectedRows, changeRows);
      },
      getCheckboxProps: record => ({
        disabled: record.name === 'Disabled User',    // Column configuration not to be checked
      }),
    };

    return (
      <div>
        <Row>
          <Col span="6">
            <Input placeholder="根据名称搜索" addonAfter={<Icon type="search" />} />
          </Col>
          <Col span="4">
          <ButtonGroup>
            <Button icon="plus" title="添加"></Button>
            <Button icon="edit" title="编辑"></Button>
            <Button icon="minus" title="删除"></Button>
            <Button icon="right" title="分配角色"></Button>
          </ButtonGroup>
            </Col>

        </Row>
        <Table
               rowSelection={rowSelection}
               columns={columns}
               dataSource={data}
               pagination={paginationCfg}
               loading={this.props.appstore.loading}
               size="small"/>
      </div>
    )
  }
}

AppPage.protoTypes = {}


function mapStateToProps({appstore}) {
  return {appstore};
}
export default connect(mapStateToProps)(AppPage);
