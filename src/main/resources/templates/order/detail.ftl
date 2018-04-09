<html>

    <#include "../common/header.ftl">
    <body>
    <div id="wrapper" class="toggled">

        <#include "../common/nav.ftl">

        <div id="page-content-wrapper">
            <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                            <tr>
                                <th>订单id</th>
                                <th>总金额</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${orderDTO.getOrderId()}</td>
                                <td>${orderDTO.getOrderAmount()}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <#--订单详情表数据-->
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>总额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDTO.getOrderDetailList() as orderDetail>
                            <tr>
                                <td>${orderDetail.getProductId()}</td>
                                <td>${orderDetail.getProductName()}</td>
                                <td>${orderDetail.getProductPrice()}</td>
                                <td>${orderDetail.getProductQuantity()}</td>
                                <td>${orderDetail.getProductQuantity() * orderDetail.getProductPrice()}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <#if orderDTO.getOrderStatusEnum().getMessage() == "新订单">
                            <a href="/sell/seller/order/finish?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-primary btn-default">完结订单</a>&nbsp;
                            <a href="/sell/seller/order/cancel?orderId=${orderDTO.getOrderId()}" type="button" class="btn btn-default btn-danger">取消订单</a>
                        </#if>
                    </div>
                </div>
        </div>
        </div>

    </div>
    </body>
</html>