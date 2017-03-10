import React from 'react';
import {Menu, Icon} from 'antd';
import {Link} from 'dva/router';
const SubMenu = Menu.SubMenu;
const SiteBar = (props) => {
  const routes = props.routes;
  let url ="device";
  if(routes && routes.length >=2){
    url = routes[1].path;
  }
  console.log("url:"+ url +"---")
  if(url == null || url ==''){
    url = 'device';
  }
  return (
    <aside className="ant-layout-sider">
      <Menu mode="inline" selectedKeys={[url]}  >
        <Menu.Item key="device"> <Link to={"/device"}>设备管理</Link></Menu.Item>
        <Menu.Item key="add-device"> <Link to={"/add-device"}>添加设备</Link></Menu.Item>
        <Menu.Item key="key"><Link to={"/key"}>秘钥管理</Link></Menu.Item>
        <Menu.Item key="add-key"><Link to={"/add-key"}>添加/编辑 秘钥</Link></Menu.Item>
      </Menu>
    </aside>
  );
};

SiteBar.propTypes = {};

export default SiteBar;
