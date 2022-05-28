function loadTwoLine(id) {
	    var myChart = echarts.init(document.getElementById('TwoLineChart'));
	    // 显示标题，图例和空的坐标轴
	    myChart.setOption({
			legend: {
				data: ['数量', '差值', '广发银行', '上海银行']
			},
			tooltip: {
				trigger: 'axis'   // axis   item   none三个值
			},
			xAxis: {
				data: ['A', 'B', 'C', 'D', 'E'],
				axisLabel: {
					//interval: 0, // 设置数据间隔
					rotate:38, // 标题倾斜
					// margin: 5, //刻度标签与轴线之间的距离
					// textStyle: {
					//  fontSize: 9, //横轴字体大小
					//  color: "#000000",//颜色
				}
			},
			yAxis: {},
			series: [
				{
					data: [10, 22, 28, 43, 49],
					type: 'line',
					stack: 'x'
				},
				{
					data: [5, 4, 3, 5, 10],
					type: 'line',
					stack: 'x'
				}
			]
		});
	    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
	    var datetimes = [];    //类别数组（实际用来盛放X轴坐标值）    
	    var flows = [];
	    $.ajax({
	        type: 'get',
	        url: 'http://localhost:8080/xingLang?id='+id,//请求数据的地址
	        dataType: "json",        //返回数据形式为json
	        success: function (result) {
//
				datetimes.push(result.date);
				flows.push(result.volume);

	            myChart.hideLoading();    //隐藏加载动画
	            myChart.setOption({
	            	//加载数据图表
	                title:{
	                	text: "每日流量趋势图"
	                },
	                xAxis: {
	                    data: result.date
	                },
	                yAxis:{},
	                series: [
	                	{
	                		name:"数量",
	                    	data: result.volume,
	                	},
						{
							name:"差值",
							data: result.val,
						},
	                ]
	            });
	        },
	        error: function (errorMsg) {
	            //请求失败时执行该函数
	            alert("图表请求数据失败!");
	            myChart.hideLoading();
	        }
	    });
	};
	loadTwoLine("sz002061");

function search() {
	let elementById = document.getElementById("inputSearch").value;
	loadTwoLine(elementById);
}
