
Dane ściągnięte z UFO ze strony http://www.infochimps.com/.

```sh
db.places.aggregate({ $group: { _id: "$location", count: {$sum: 1 }}},{$sort: { count: -1 }},{$limit: 10})
{
	"result" : [
		{
			"_id" : " Seattle, WA",
			"count" : 440
		},
		{
			"_id" : " Phoenix, AZ",
			"count" : 377
		},
		{
			"_id" : " Los Angeles, CA",
			"count" : 294
		},
		{
			"_id" : " San Diego, CA",
			"count" : 274
		},
		{
			"_id" : " Las Vegas, NV",
			"count" : 271
		},
		{
			"_id" : " Portland, OR",
			"count" : 253
		},
		{
			"_id" : " Houston, TX",
			"count" : 247
		},
		{
			"_id" : " Chicago, IL",
			"count" : 219
		},
		{
			"_id" : " Tucson, AZ",
			"count" : 187
		},
		{
			"_id" : " London (UK/England),",
			"count" : 174
		}
	],
	"ok" : 1
}
```

![Wystąpienia ufo wg miast](../../images/tjanuszewski/wykres1.png)


```sh
db.places.aggregate({ $group: { _id: {$substr:["$sighted_at",4,2]}, count: {$sum: 1 }}},{$sort: { _id: 1 }})
{
	"result" : [
		{
			"_id" : "",
			"count" : 252
		},
		{
			"_id" : "00",
			"count" : 2
		},
		{
			"_id" : "01",
			"count" : 4233
		},
		{
			"_id" : "02",
			"count" : 3629
		},
		{
			"_id" : "03",
			"count" : 4150
		},
		{
			"_id" : "04",
			"count" : 4095
		},
		{
			"_id" : "05",
			"count" : 4181
		},
		{
			"_id" : "06",
			"count" : 6707
		},
		{
			"_id" : "07",
			"count" : 7311
		},
		{
			"_id" : "08",
			"count" : 6616
		},
		{
			"_id" : "09",
			"count" : 5630
		},
		{
			"_id" : "10",
			"count" : 5394
		},
		{
			"_id" : "11",
			"count" : 4932
		},
		{
			"_id" : "12",
			"count" : 3913
		}
	],
	"ok" : 1
	
```	
	![Wystąpienia ufo wg miesięcy](../../images/tjanuszewski/wykres2.png)
}
