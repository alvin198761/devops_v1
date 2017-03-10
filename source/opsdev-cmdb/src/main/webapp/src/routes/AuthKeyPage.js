import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Button, Icon, Input, Table, Row, Col} from 'antd';
import {Link} from 'dva/router';
import  './IndexPage.css';

const ButtonGroup = Button.Group;
const Search = Input.Search;

const columns = [{
  title: '秘钥名称',
  dataIndex: 'outerIp',
  key: 'outerIp',
  render: text => <a href="#">{text}</a>,
}, {
  title: '类型',
  dataIndex: 'innerIP',
  key: 'innerIP',
}, {
  title: '用户名',
  dataIndex: 'port',
  key: 'port',
}
  , {
    title: '操作',
    key: 'ops',
    dataIndex: "ops"
  }
];

class AuthKeyPage extends Component {

  constructor(props) {
    super(props);
    this.state = {
      page: 1
    }
  }

  componentWillMount() {
    this.props.dispatch({
      type: 'authKey/fetchPage', payload: {
        page: this.state.page
      }
    });
  }

  render() {
    return ( <div>
      <Row>
        <Col span="5">
          <Search placeholder="输入名称查找" style={{width: '100%'}}/>
        </Col>
        <Col span="6"><ButtonGroup>
          <Button title="添加" onClick={()=>location.href = "#/add-key"}><Icon type="plus"/></Button>
        </ButtonGroup></Col>
      </Row>
      <Table columns={columns} dataSource={this.props.authkey.pageKeys}> </Table>
    </div>);
  }
}

AuthKeyPage.propTypes = {};

function mapStateToProps({authkey}) {
  return {authkey}
}

export default connect(mapStateToProps)(AuthKeyPage);
