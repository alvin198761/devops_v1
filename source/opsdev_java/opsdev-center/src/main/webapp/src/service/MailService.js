import reqwest from '../utils/reqwest'

export function settingMail(param) {
    console.log(param);
  return  reqwest({
        method :'post',
        url:'mail/setting',
        data:[param],
        type:'json'
    })
}