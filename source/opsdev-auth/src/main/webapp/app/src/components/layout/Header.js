import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import {Menu, Icon, Row, Col} from 'antd';

const SubMenu = Menu.SubMenu;

const Header = (props) => {
  return (
    <div className="ant-layout-header">
      <div className="ant-layout-wrapper">
        <div className="ant-layout-logo">
          <Icon type="lock" /> 统一登录
        </div>
        <Row>
          <Col span="18">
            <Menu theme="dark" mode="horizontal"
                  defaultSelectedKeys={[]} className="header-menu">
              <SubMenu key="office" title={<span> <Icon type="dingding" /> <span>行政系统</span></span>}>
                <Menu.Item key="opsdev_oa">人员管理</Menu.Item>
              </SubMenu>
              <SubMenu key="resouce" title={<span> <Icon type="hdd" /> <span>基础设施</span></span>}>
                <Menu.Item key="opsdev_cmdb">资源管理</Menu.Item>
                <Menu.Item key="opsdev_project">项目管理</Menu.Item>
              </SubMenu>
              <SubMenu key="devops" title={<span> <Icon type="windows" /> <span>系统运维</span></span>}>
                <Menu.Item key="opsdev_center">远程执行</Menu.Item>
                <Menu.Item key="opsdev_sync">数据库同步</Menu.Item>
                <Menu.Item key="opsdev_monitor">监控中心</Menu.Item>
              </SubMenu>
            </Menu>
          </Col>
          <Col span="2" >
            <Menu mode="horizontal" theme="dark" className="header-menu" style={{float:'right'}}>
              <SubMenu key="user" title={<span> <Icon type="user"/> <span>用户</span></span>}>
                <Menu.Item key="2">设置</Menu.Item>
                <Menu.Item key="1"><a href="j_spring_security_logout">退出登录</a></Menu.Item>
              </SubMenu>
            </Menu>
          </Col>
        </Row>
      </div>
    </div>
  );
};

Header.propTypes = {};

export default Header;
