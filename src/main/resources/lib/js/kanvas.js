
var  ctx = document.getElementById('kanvas');
var myChart = new Chart(ctx, {
    type: 'Graphics',
    data: {
        labels: ["July 1", "July 2", "July 3", "July 4", "July 5", "July 6", "July 7", "July 8", "July 9", "July 10", "July 11", "July 12", "July 13"],
        datasets: [{
            label: 'Sales Actions',
            data: ["250","250","250","241","235","230","239","232","229","219","209","210","220"],
        }]

    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
