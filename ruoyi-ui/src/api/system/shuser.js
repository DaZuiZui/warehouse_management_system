import request from '@/utils/request'

// 查询用户列表
export function listShuser(query) {
  return request({
    url: '/system/shuser/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getShuser(id) {
  return request({
    url: '/system/shuser/' + id,
    method: 'get'
  })
}

// 新增用户
export function addShuser(data) {
  return request({
    url: '/system/shuser', 
    method: 'post',
    data: data
  })
}

// 修改用户
export function updateShuser(data) {
  return request({
    url: '/system/shuser',
    method: 'put',
    data: data
  })
}

// 删除用户
export function delShuser(id) {
  return request({
    url: '/system/shuser/' + id,
    method: 'delete'
  })
}
