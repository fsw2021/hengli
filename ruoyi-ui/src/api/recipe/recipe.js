import request from '@/utils/request'


/** 查询mongodb DB2002(配料表)中的信息 */
export function getBasicDB02(query){
  return request({
    url: '/recipe/entrarecipe' ,
    method: 'get',
    params: query
  })
}
/** 查询mongodb DB2003(配料表)中的信息 */
export function getBasicDB03(query){
  return request({
    url: '/recipe/stackerrecipe' ,
    method: 'get',
    params: query
  })
}
/** 查询mongodb DB2005(配料表)中的信息 */
export function getBasicDB05(query){
  return request({
    url: '/recipe/pressrecipe' ,
    method: 'get',
    params: query
  })
}


/*

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
}*/



