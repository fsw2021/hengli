import request from '@/utils/request'

// 查询生产任务管理列表
export function listTask(query) {
  return request({
    url: '/lineInfo/task/list',
    method: 'get',
    params: query
  })
}

// 查询生产任务管理详细
export function getTask(id) {
  return request({
    url: '/lineInfo/task/' + id,
    method: 'get'
  })
}

// 新增生产任务管理
export function addTask(data) {
  return request({
    url: '/lineInfo/task',
    method: 'post',
    data: data
  })
}

// 修改生产任务管理
export function updateTask(data) {
  return request({
    url: '/lineInfo/task',
    method: 'put',
    data: data
  })
}

// 删除生产任务管理
export function delTask(id) {
  return request({
    url: '/lineInfo/task/' + id,
    method: 'delete'
  })
}

// 导出生产任务管理
export function exportTask(query) {
  return request({
    url: '/lineInfo/task/export',
    method: 'get',
    params: query
  })
}