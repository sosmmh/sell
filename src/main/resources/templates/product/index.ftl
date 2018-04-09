<html>

    <#include "../common/header.ftl">

    <body>
    <div id="wrapper" class="toggled">
        <#--边栏-->
        <#include "../common/nav.ftl">

        <#--主要内容区域-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <form role="form">
                            <div class="form-group">
                                <label>名称</label><input name="productName" type="text" class="form-control" value="${productInfo.getProductName()}"/>
                            </div>
                            <div class="form-group">
                                <label>价格</label><input name="productPrice" type="text" class="form-control" value="${productInfo.getProductPrice()}"/>
                            </div>
                            <div class="form-group">
                                <label>库存</label><input name="productStock" type="text" class="form-control" value="${productInfo.getProductStock()}"/>
                            </div>
                            <div class="form-group">
                                <label>描述</label><input name="productDescription" type="text" class="form-control" value="${productInfo.getProductDescription()}" />
                            </div>
                            <div class="form-group">
                                <label>图片</label><input name="productIcon" type="file" id="exampleInputFile" />
                                <p class="help-block">
                                    Example block-level help text here.
                                </p>
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" />Check me out</label>
                            </div> <button type="submit" class="btn btn-default">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>