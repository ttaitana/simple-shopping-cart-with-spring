# Database and Data Dictionary

## Database Name : toy
### Table name : products
| **Name**  | **Type**     | **Description**  | **Example** |
| ----------|:------------ |:---------------- |:-----------:|
| id | int | รหัสสินค้า | 2 |
| product_name | varchar | ชื่อสินค้า | 43 Piece dinner Set |
| product_brand | varchar | ยี่ห้อสินค้า | Coolkidz |
| quantity | int | จำนวน | 1 |
| product_price | double | ราคาสินค้า | 12.95 |
| image_url | varchar | รูปภาพ | 43_Piece_Dinner_Set.jpg |
| updated | timestamp | วันที่อัพเดทข้อมูล | 2020-03-02 16:28:54 |
| created | timestamp | วันที่สร้างข้อมูล | 2020-03-02 16:28:54 |


### Table name : order_product
| **Name**  | **Type**     | **Description**  | **Example** |
| ----------|:------------ |:---------------- |:-----------:|
| order_id | int | รหัสคำสั่งซื้อ | 8004359103 |
| product_id | int | รหัสสินค้า | 2 |
| quantity | int | จำนวน | 1 |
| product_price | double | ราคาสินค้า | 12.95 |


### Table name : shipping
| **Name**  | **Type**     | **Description**  | **Example** |
| ----------|:------------ |:---------------- |:-----------:|
| id | int | รหัสที่อยู่จัดส่ง | 1 |
| order_id | int | รหัสคำสั่งซื้อ | 8004359103 |
| address | varchar | ที่อยู่ | 405/37 ถ.มหิดล |
| sub_district | varchar | ตำบล | ท่าศาลา |
| district | varchar | อำเภอ | เมือง |
| province | varchar | จังหวัด | เชียงใหม่ |
| zip_code | varchar | รหัสไปรษณีย์ | 50000 |
| recipient | varchar | ชื่อผู้รับ | ณัฐญา ชุติบุตร |
| phone_number | varchar | เบอร์โทรศัพท​์ | 0970809292 |
| updated | timestamp | วันที่อัพเดทข้อมูล | 2020-03-02 16:28:54 |
| created | timestamp | วันที่สร้างข้อมูล | 2020-03-02 16:28:54 |


### Table name : orders
| **Name**  | **Type**     | **Description**  | **Example** |
| ----------|:------------ |:---------------- |:-----------:|
| id | int | รหัสคำสั่งซื้อ | 8004359103 |
| total_price | double | ราคารวม | 14.95 |
| transaction_id | varchar | หมายเลขธุรกรรม | TOY202002021525 |
| completed | smallint | สถานะคำสั่งซื้อ | 1 |
| authorized | timestamp | วันเวลาที่ชำระเงิน | 2020-03-02 16:28:54 |
| updated | timestamp | วันที่อัพเดทข้อมูล | 2020-03-02 16:28:54 |
| created | timestamp | วันที่สร้างข้อมูล | 2020-03-02 16:28:54 |

