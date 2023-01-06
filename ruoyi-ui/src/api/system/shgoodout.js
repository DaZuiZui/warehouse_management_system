import request from '@/utils/request'

// 查询商品出库列表
export function listShgoodout(query) {
  return request({
    url: '/system/shgoodout/list',
    method: 'get',
    params: query
  })
}

// 查询商品出库详细
export function getShgoodout(id) {
  return request({
    url: '/system/shgoodout/' + id,
    method: 'get'
  })
}

// 新增商品出库
export function addShgoodout(data) {
  return request({
    url: '/system/shgoodout',
    method: 'post',
    data: data
  })
}

// 修改商品出库
export function updateShgoodout(data) {
  return request({
    url: '/system/shgoodout',
    method: 'put',
    data: data
  })
}

// 删除商品出库
export function delShgoodout(id) {
  return request({
    url: '/system/shgoodout/' + id,
    method: 'delete'
  })
}
