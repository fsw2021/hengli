import request from '@/utils/request'

// 查询产线管理列表
export function listBasic(query) {
  return request({
    url: '/lineInfo/basic/list',
    method: 'get',
    params: query
  })
}

// 查询产线管理详细
export function getBasic(id) {
  return request({
    url: '/lineInfo/basic/' + id,
    method: 'get'
  })
}
// 查询mongodb DB2000中的信息
export function getBasicDB00(){
  return request({
    url: '/lineInfo/basic' ,
    method: 'get'
  })
}
// 查询mongodb DB2001中的信息
export function getBasicDB01(){
  return request({
    url: '/lineInfo/basic/db01' ,
    method: 'get'
  })
}
// //查询mongodb DB2002(配料表)中的信息
// export function getBasicDB02(query){
//   return request({
//     url: '/lineInfo/basic/db02' ,
//     method: 'get',
//     params: query
//   })
// }


// 新增产线管理
export function addBasic(data) {
  return request({
    url: '/lineInfo/basic',
    method: 'post',
    data: data
  })
}

// 修改产线管理
export function updateBasic(data) {
  return request({
    url: '/lineInfo/basic',
    method: 'put',
    data: data
  })
}

// 删除产线管理
export function delBasic(id) {
  return request({
    url: '/lineInfo/basic/' + id,
    method: 'delete'
  })
}

// 导出产线管理
export function exportBasic(query) {
  return request({
    url: '/lineInfo/basic/export',
    method: 'get',
    params: query
  })
}
