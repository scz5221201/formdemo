import { Message } from 'element-ui'
import axios from 'axios'
import router from "../router";

axios.interceptors.response.use(success => {
    // success.status:表示http响应状态码
    // success.data:表示后端返回的json数据
    // success.data.status:表示后端返回json数据中的状态码，后端已对其进行区分，200，500
    if (success.status && success.status === 200 && success.data.status === 500) {
        Message.error({message: success.data.msg}) //弹出消息提示框，并从后端返回的json数据中去除msg的内容显示在界面中
        return; //此处返回空值。从后端得到响应后，判断得到响应的数据是否为空，若为空，则将上面一行显示在界面上，否则返回后端的json数据
    } else if (success.status && success.status === 200 && success.data.status === 403) {
        Message.error({message: success.data.msg}) //弹出消息提示框，并从后端返回的json数据中去除msg的内容显示在界面中
        return
    }
    if (success.data.msg) {
        Message.success({message: success.data.msg})
    }
    return success.data

}, error => {

    if (error.response.status === 504 || error.response.status === 404) {
        Message.error({message: "网页丢失"})
    } else if (error.response.status === 403) {
        Message.error({message: "权限不足，请联系管理员"})
    } else if (error.response.status === 401) {
        Message.error({message: "尚未登录，请重新登录"})
        router.replace("/")
    } else {
        if (error.response.data.msg) {
            Message.error({message: error.response.data.msg})
        } else {
            Message.error({message: "服务器繁忙"})
        }
    }
    return;
});

let base = '';

export const postRequest = (url, params) => {
    return axios({
        method: 'post',
        url: `${base}${url}`,
        data: params
    })
}
export const putRequest = (url, params) => {
    return axios({
        method: 'put',
        url: `${base}${url}`,
        data: params
    })
}
export const getRequest = (url, params) => {
    return axios({
        method: 'get',
        url: `${base}${url}`,
        data: params
    })
}
export const deleteRequest = (url, params) => {
    return axios({
        method: 'delete',
        url: `${base}${url}`,
        data: params
    })
}