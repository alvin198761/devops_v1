import React, {Component, PropTypes} from 'react';
import {Menu, Breadcrumb, Icon, Row, Col} from 'antd';
import {connect} from 'dva';
import {Link ,browserHistory} from 'dva/router';


const SubMenu = Menu.SubMenu;

class Aside extends Component {

  constructor(porps) {
    super(porps);
  }

  componentWillMount() {

  }

  render() {
    console.log(this.props)
    return (
      <aside className="ant-layout-sider">
          <Menu mode="inline" defaultSelectedKeys={['/applist']} defaultOpenKeys={['sub1']}>
            <SubMenu key="sub1" title={<span><Icon type="user" />应用管理</span>}>
              <Menu.Item key="/applist"><Link to="/setting/applist">App 列表</Link></Menu.Item>
              <Menu.Item key="2"><Link to="/setting/addapp">App 添加</Link></Menu.Item>
            </SubMenu>
            <SubMenu key="sub2" title={<span><Icon type="laptop" />用户权限</span>}>
              <Menu.Item key="7">用户管理</Menu.Item>
              <Menu.Item key="8">权限分配</Menu.Item>
            </SubMenu>
          </Menu>
        </aside>
    )
  }
}

Aside.propTypes = {};

function mapStateToProps({main}) {
  return {main};
}

export default connect(mapStateToProps)(Aside);
