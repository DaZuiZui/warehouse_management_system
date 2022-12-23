import request from '@/utils/request'

// 查询商品列表
export function listShgood(query) {
  return request({
    url: '/system/shgood/list',
    method: 'get',
    params: query
  })
}

// 查询商品详细
export function getShgood(id) {
  return request({
    url: '/system/shgood/' + id,
    method: 'get'
  })
}

// 新增商品
export function addShgood(data) {
  return request({
    url: '/system/shgood',
    method: 'post',
    data: data
  })
}

// 修改商品
export function updateShgood(data) {
  return request({
    url: '/system/shgood',
    method: 'put',
    data: data
  })
}

// 删除商品
export function delShgood(id) {
  return request({
    url: '/system/shgood/' + id,
    method: 'delete'
  })
}
