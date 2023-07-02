# javaLibrary
Dự án Java basic: Chương trình quản lý thư viện.
Mô tả: Xây dựng một chương trình quản lý thông tin sách và độc giả trong thư viện có thể bao gồm các tính năng sau:
- Đăng nhập set quyền: Quyền quản lý của Manager – Tạo userReader mới
- Thêm sách mới vào danh sách. - Manager
- Hiển thị danh sách sách trong thư viện. – Manager/Reader
- Tìm kiếm thông tin của một cuốn sách bằng mã số sách hoặc tên sách. -Manager/Reader
- Cập nhật thông tin của một cuốn sách. - Manager
- Xóa sách khỏi danh sách. - Manager
- Thêm độc giả mới vào danh sách. – Manager/Reader(Tạo account mới)
- Hiển thị danh sách độc giả trong thư viện. – Manager/Reader
- Tìm kiếm thông tin của một độc giả bằng mã số độc giả hoặc tên độc giả.-Manager
- Cập nhật thông tin của một độc giả.-Manager/Reader(Đăng nhập user đó)
- Xóa độc giả khỏi danh sách.-Manager
- Thêm sách vào hàng mượn/ Trả sách – Manager/Reader(Có account của bản thân)
- Nhắc nhở trả sách – Manager
- Coming soon….
Để triển khai chương trình quản lý thư viện trong Java theo mô hình MVC (Model-View-Controller), ta phân cấp các thành phần như sau:
1.	Model:
- Book: Lớp cha chứa thuộc tính chung của sách. Nhằm thừa kế cho các loại sách khác
- Person: Là lớp cha. Để thừa kế cho 2 đối tượng Reader và Manager
- UserAccount: Đối tượng cho UserAccount.
- Reader : Thừa kế từ lớp cha Person. Chứa thêm các thuộc tính riêng của reader
- Manager: Lớp đại diện cho quản lý thư viện trong hệ thống. Thừa kế từ People
- Coming Soon…
2.	View:
- LoginFormView: Giao diện người dùng. Hiển thị cho người dùng thấy và tương tác.
- SearchingFormView: Hiển thị kết quả tìm kiếm, thông báo lỗi hoặc thông báo khi thao tác thành công.
- InterfaceUserFormView: Lớp này sẽ được sử dụng để hiển thị form đăng nhập cho người dùng.
- ReaderDetailView: Lớp này sẽ được sử dụng để hiển thị chi tiết của một reader trong hệ thống.
- BookFormView: Hiển thị cho phần Book.
- Coming Soon……
3.	Controller:
- BookController: Quản lý các loại sách. Controller hợp lý theo yêu cầu của user đưa ra kết quả cho user.
- UserController: Lớp này sẽ được sử dụng để quản lý các tài khoản người dùng trong hệ thống. Từ đó phân quyền cho hợp lý.
- ReaderController: Lớp này được sử dụng nếu User là 1 Reader và sẽ được phân các quyền mà 1 reader được dùng.
- ManagerLibraryController: Lớp này được sử dụng nếu User là 1 Manager của Library và sẽ được phần quyền quản lý mà 1 quản lý được phép
- IOController: Quản lý về Input và Output từ file.
- Coming Soon…..
