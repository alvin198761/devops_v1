import React from 'react';
import {Menu, Icon, Row, Col} from 'antd';
import { Link } from 'dva/router';
const SubMenu = Menu.SubMenu;

const OHeader = (props) => {
  return (
    <div className="ant-layout-header">
      <div className="ant-layout-wrapper">
        <Row>
          <Col span="2"><div className="ant-layout-logo"><b style={{fontSize:'16px',color:'#fff'}}><Icon type="cloud" />&nbsp;&nbsp;设备管理</b></div></Col>
          <Col span="20"> <Menu theme="dark" mode="horizontal"
                                defaultSelectedKeys={['2']} style={{lineHeight: '64px'}}>
            {/*<Menu.Item key="1"  >*/}
             {/*<Link to={"server"}>服务器</Link> </Menu.Item>*/}
            {/*<Menu.Item key="2">权限</Menu.Item>*/}
          </Menu></Col>
          <Col span="2">
            <Menu theme="dark" mode="horizontal"  style={{lineHeight: '64px'}}>
              <SubMenu title={<span><Icon type="user" />用户</span>}>
                <Menu.Item key="2"><a href="/j_spring_security_logout"><Icon type="logout" />退出</a></Menu.Item>
              </SubMenu>
            </Menu>
          </Col>
        </Row>
      </div>
    </div>
  );
};

OHeader.propTypes = {};

export default OHeader;
