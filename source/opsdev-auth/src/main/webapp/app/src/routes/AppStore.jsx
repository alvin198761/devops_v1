import React, {Component, PropTypes} from 'react';
import {connect} from 'dva';
import {Link} from 'dva/router';
import './IndexPage.css';
import {Carousel, Row, Col, Icon, Card,Spin} from 'antd';

class AppStore extends Component {

  constructor(props) {
    super(props);
  }

  onChange(current) {

  }

  componentWillMount() {
    console.log("componentWillMount")
    this.props.dispatch({type: 'appstore/fetchAll'})
  }

  render() {

    const appItem = (item)=> {
      return (  <Col span="7" push="1" key={item.url}>
        <Card title={item.title} extra={<a href="#" title="设置"><Icon type="setting" /></a>}
              style={{   height:'200px' ,margin:'10px'}}>
          <div>
            <Row>
              <Col span="8" style={{ fontSize:'60px', fontWeight: 'bold',textAlign:'center'}}>
                <Icon type="hdd"/>
              </Col>
              <Col span="15" push="1">
                <a href={item.url}>点击打开</a>
                <div style={{paddingTop:'10px'}}>{item.description}</div>
              </Col>
            </Row>
          </div>
        </Card>
      </Col>)
    }
    return (
    <Spin size="large" spinning={this.props.appstore.loading} >
        <div className="ant-layout-content">
          <div >
            <div className="appstroe-box">
              {this.props.appstore.page.length > 0 && <Carousel afterChange={this.onChange.bind(this)}>
                {
                  this.props.appstore.page.map(item =>
                    <div key={item.name}>
                      <Row
                        style={{marginBottom:40}}>   { item.apps.map(appItem)  }
                      </Row>
                    </div>
                  )
                }
              </Carousel> }
            </div>
          </div>
        </div>
      </Spin>
    );
  }
}

AppStore.protoTypes = {}

function mapStateToProps({appstore}) {
  return {appstore};
}
export default connect(mapStateToProps)(AppStore);
