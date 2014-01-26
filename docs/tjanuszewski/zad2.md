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
