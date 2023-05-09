package com.example.backend.controller;
import com.example.backend.entity.*;
import com.example.backend.payload.FileResponse;
import com.example.backend.repository.TransactionDetailRepository;
import com.example.backend.repository.UserOrdersRepository;
import com.example.backend.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private ServiceStorage serviceStorage;
    @Autowired
    private AdminServices adminServices;

    @Autowired
    private UserOrdersRepository userOrdersRepository;

    @Autowired
    private AllUserOrdersServices allUserOrdersServices;


    @Autowired
    private SellerSignupServices sellerSignupServices;

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    @Autowired
    private TransactionDetailServices transactionDetailServices;

    @Autowired
    CheckOutServices checkOutServices;

    @Autowired
    private BuyerDetailServices buyerDetailServices;

    @Autowired
    private AddcategoryServices addcategoryServices;

    @Autowired
    private CartServices cartServices;

    @Autowired
    private ReviewsServices reviewsServices;
    @Autowired
    private SMSServices smsServices;

    @Value("src/main/resources/static/images/")
    private String path;
    
    private AddproductServices addproductServices;
    public Controller(AddproductServices addproductServices) {
        this.addproductServices = addproductServices;
    }

    // Create AddProducts REST API
    @CrossOrigin
    @RequestMapping(value = "/api/addproducts", method = RequestMethod.POST)
    public Addproduct Addproducts(@RequestBody Addproduct addproduct){
        Addproduct allproduct1 = addproductServices.addProduct(addproduct);
        return allproduct1;
    }

    // Create buyerSignup REST API
    @CrossOrigin
    @RequestMapping(value = "/api/buyerSignup", method = RequestMethod.POST)
    public ResponseEntity<BuyerAccountDetail> Buyersignup(@RequestBody  BuyerAccountDetail buyerAccountDetail){
        BuyerAccountDetail buyerAccountDetail1 = buyerDetailServices.savebuyerdetails(buyerAccountDetail);
        return new ResponseEntity<BuyerAccountDetail>(buyerAccountDetail1, HttpStatus.CREATED);

    }


    // Create signup REST API
    @CrossOrigin
    @RequestMapping(value = "/api/signup", method = RequestMethod.POST)
    public ResponseEntity<String> Sellersignup(@RequestBody  SellerSignup sellersignup){
        String sellerSignup1 = sellerSignupServices.savesellerdetails(sellersignup);
        return new ResponseEntity<String>(sellerSignup1, HttpStatus.CREATED);

    }

    //Get ALL Products



//    image Upload
    @CrossOrigin
    @RequestMapping(value="/api/upload", method = RequestMethod.POST)
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile multipartFile) throws IOException {
            String filePath = this.serviceStorage.uploadImage(path,multipartFile);
            return new ResponseEntity<>( new FileResponse(filePath,"Image is successfully uploaded !!",path),HttpStatus.OK);
    }
    // build GET AddProducts REST API
    @CrossOrigin
    @RequestMapping(value = "/api/addproducts/{id}", method = RequestMethod.GET)
    public  ResponseEntity<List<Addproduct>>  getAllProducts(@PathVariable("id") String id)
    {
        List <Addproduct> list = addproductServices.getAllProducts(id);
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.of(Optional.of(list));
        }
    }


    // Review
    @CrossOrigin
    @RequestMapping(value = "/api/postReview", method = RequestMethod.POST)
    public  ResponseEntity<List<Reviews>>  postReviews(@RequestBody Reviews reviews)
    {
      reviewsServices.postReviews(reviews);
        HttpStatus statusCode = HttpStatus.OK;
        return new ResponseEntity<>(statusCode);
    }


    // Get an employee by Id
    @CrossOrigin
    @RequestMapping(value = "/api/getbyid/{id}", method = RequestMethod.GET)
    public Optional<Addproduct> getUserById(@PathVariable("id") int id)

    {
        return addproductServices.getUserById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/updatebyid", method = RequestMethod.PUT)
    public Addproduct updateUserById(@RequestBody Addproduct addproduct) {
       return addproductServices.updateUserById(addproduct);
    }

//    @CrossOrigin
//    @RequestMapping(value = "/api/deleteBuyerById/{id}", method = RequestMethod.DELETE)
//    public Addproduct deleteproducts(@PathVariable("id") int id){
//            return addproductServices.deleteProduct(id);
//    }


    @CrossOrigin
    @RequestMapping(value = "/api/sellerlogin", method = RequestMethod.POST)
    public ResponseEntity<Object> SellerLogin(@RequestBody  SellerSignup sellersignup){
     SellerSignup  sellerSignup1 = sellerSignupServices.SellerLogin(sellersignup);
        return ResponseEntity.ok(sellerSignup1);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/addtoCart/{id}", method = RequestMethod.POST)
    public Cart addToCart(@RequestBody  Cart cart, @PathVariable("id") int buyerAccountId){
        Cart addtocart1 = cartServices.addtoCart(cart ,buyerAccountId);
        return addtocart1;

    }

    @CrossOrigin
    @RequestMapping(value = "/api/buyerlogin", method = RequestMethod.POST)
    public BuyerAccountDetail BuyerLogin(@RequestBody  BuyerAccountDetail buyerAccountDetail){
        BuyerAccountDetail buyerAccountDetail1 = buyerDetailServices.BuyerLogin(buyerAccountDetail);
        return buyerAccountDetail1;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getcart/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCart(@PathVariable("id") int buyerCartId){
        List<Cart> list  = cartServices.getAllCart(buyerCartId);

            return ResponseEntity.of(Optional.of(list));
        }

    // delete Cart Item

        @CrossOrigin
        @RequestMapping(value = "/api/deleteProduct/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id){

             List<Cart> list =   cartServices.deleteProduct(id);
             HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(list,statusCode);

        }


        // Admin Side Start
        @CrossOrigin
        @RequestMapping(value = "/api/AllSignupUser", method = RequestMethod.GET)
        public ResponseEntity<Object> AllSeller(SellerSignup sellerSignup){
            List<SellerSignup> list = sellerSignupServices.getAllSeller(sellerSignup);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(list,statusCode);
        }

        @CrossOrigin
        @RequestMapping(value = "/api/getCategory", method = RequestMethod.GET)
        public ResponseEntity<Object> GetCategory(){
            List<AddCategoris> list = addcategoryServices.getCategories();
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(list,statusCode);
        }

        @CrossOrigin
        @RequestMapping(value = "/api/getSellerByID/{id}", method = RequestMethod.GET)
        public ResponseEntity<Object> getSellerByID(@PathVariable("id") int id){
            Optional<SellerSignup> list = sellerSignupServices.getSellerByID(id);
            HttpStatus statusCode = HttpStatus.OK;

            return new ResponseEntity<>(list,statusCode);
        }

        @CrossOrigin
        @RequestMapping(value = "/api/AllBuyerUser", method = RequestMethod.GET)
        public ResponseEntity<Object> Allbuyer(BuyerAccountDetail buyerAccountDetail){
            List<BuyerAccountDetail> list = buyerDetailServices.getAllbuyer(buyerAccountDetail);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(list,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/deleteBuyerById/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Object> deleteBuyer(@PathVariable("id") int id){
            List<BuyerAccountDetail> list =   buyerDetailServices.deleteBuyer(id);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(list,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/addCategory", method = RequestMethod.POST)
        public ResponseEntity<Object> AddCategory(@RequestBody AddCategoris addCategoris){
            List<AddCategoris> list = addcategoryServices.saveCatetory(addCategoris);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(list,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/DeleteByID/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Object> DeleteByID(@PathVariable("id") int id){
            List<SellerSignup> list = sellerSignupServices.deleteById(id);
            HttpStatus statusCode = HttpStatus.OK;

            return new ResponseEntity<>(list,statusCode);
        }
    @CrossOrigin
    @RequestMapping(value = "/api/DeleteSellerProductByID/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> DeleteSellerProductByID(@PathVariable("id") String id){
        List<Addproduct> list = addproductServices.deleteProductId(id);
        HttpStatus statusCode = HttpStatus.OK;

        return new ResponseEntity<>(list,statusCode);
    }



        //End Admin Side

        @CrossOrigin
        @RequestMapping(value = "/api/checkout", method = RequestMethod.POST)
        public AllProduct Checkout(@RequestBody AllProduct allProduct){
            AllProduct allProduct1 =   checkOutServices.addCheckout(allProduct);
            return allProduct1;
        }
        //Remove Seller By Id
        //End DELETEByID Function

    @CrossOrigin
    @RequestMapping(value = "/api/buyerProducts", method = RequestMethod.POST)
    public ResponseEntity<String> AllUserOrders(@RequestBody List<AllUserOrders> allUserOrders){
        userOrdersRepository.saveAll(allUserOrders);
        return ResponseEntity.ok("Order created successfully");
//        AllUserOrders allUserOrders1 =  userOrdersServices.addorders(allUserOrders);
//        return allUserOrders1;
    }
    @CrossOrigin
    @RequestMapping(value = "/api/getBuyerProducts", method = RequestMethod.GET)
    public ResponseEntity<Object> getalluserorderdata(){
     List<AllUserOrders> list = allUserOrdersServices.getalluserorderdata();
        HttpStatus statusCode = HttpStatus.OK;
        return new ResponseEntity<>(list,statusCode);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/getBuyerProductsDetail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getalluserorderdata(@PathVariable("id") int id){
        Optional<AllUserOrders> list = allUserOrdersServices.getalluserorderdatadetail(id);
        HttpStatus statusCode = HttpStatus.OK;
        return new ResponseEntity<>(list,statusCode);
    }
    @CrossOrigin
    @RequestMapping(value = "/api/BuyerProductsDetailStatus/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> BuyerProductsDetailStatus(@PathVariable("id") int id ){
        List<AllUserOrders> list =allUserOrdersServices.alluserorderdatadetailStatus(id);
        HttpStatus statusCode = HttpStatus.OK;
        return new ResponseEntity<>(list,statusCode);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/deletecart/{id}", method = RequestMethod.DELETE)
    public List<Cart> deletecart(@PathVariable("id") int id){
       List<Cart> cart1 =  cartServices.deleteCartById(id);
       return cart1;
    }
    @CrossOrigin
    @RequestMapping(value = "/api/deleteBuyerProducts/{id}", method = RequestMethod.DELETE)
    public List<AllUserOrders> deleteBuyerProduct(@PathVariable("id") int id){
        List<AllUserOrders> allUserOrders =  allUserOrdersServices.deleteProductById(id);
        return allUserOrders;
    }

    @CrossOrigin
    @RequestMapping(value = "/api/tranasctiondata", method = RequestMethod.POST)
    public ResponseEntity<Object> TransactionData(@RequestBody TransactionDetail transactionDetail){
        transactionDetailRepository.save(transactionDetail);
//      List<TransactionDetail> transactionDetails=  transactionDetailServices.transactionData(transactionDetail);
//        HttpStatus statusCode = HttpStatus.OK;
        return ResponseEntity.ok("Transaction created successfully");
        }
        @CrossOrigin
        @RequestMapping(value = "/api/getCompletedOrder", method = RequestMethod.GET)
        public ResponseEntity<Object> getCompletedOrder(){
            //transactionDetailRepository.save(transactionDetail);
            List<AllUserOrders> allUserOrders =  allUserOrdersServices.completedOrder();
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(allUserOrders,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/updateSellerSetting/{id}", method = RequestMethod.PATCH)
        public ResponseEntity<Object> upDateSellerSetting(@PathVariable("id") int id, @RequestBody SellerSignup sellerSignup){
                                sellerSignupServices.updateSetting(id,sellerSignup);
           return ResponseEntity.ok("User Update successfully");
        }

        @CrossOrigin
        @RequestMapping(value = "/api/updateBuyerSetting/{id}", method = RequestMethod.PATCH)
        public ResponseEntity<Object> upDateBuyerSetting(@PathVariable("id") int id, @RequestBody BuyerAccountDetail buyerAccountDetail){
            buyerDetailServices.updateSetting(id,buyerAccountDetail);
            return ResponseEntity.ok("User Update successfully");
        }
        @CrossOrigin
        @RequestMapping(value = "/api/getBuyerProduct/{id}", method = RequestMethod.GET)
        public ResponseEntity<Object> getBuyerProduct(@PathVariable("id") String id){
        List<AllUserOrders> allUserOrders =   allUserOrdersServices.getBuyerProduct(id);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(allUserOrders,statusCode);

        }
        @CrossOrigin
        @RequestMapping(value = "/api/getBuyerProductBySatus/{id}", method = RequestMethod.GET)
        public ResponseEntity<Object> getBuyerProductByStatus(@PathVariable("id") String id){
            List<AllUserOrders> allUserOrders =   allUserOrdersServices.getBuyerProductByStatus(id);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(allUserOrders,statusCode);

        }

        @CrossOrigin
        @RequestMapping(value = "/api/getAllproducts", method = RequestMethod.GET)
        public ResponseEntity<Object> getAllProducts(){
            List<Addproduct> addproducts = addproductServices.getAllProducts();
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(addproducts,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/getSellerProduct/{id}", method = RequestMethod.GET)
        public ResponseEntity<Object> getSellerProducts(@PathVariable("id") String id){
            List<AllUserOrders> allUserOrders = allUserOrdersServices.getsellerProduct(id);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(allUserOrders,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/getSellerProductByStatus/{id}", method = RequestMethod.GET)
        public ResponseEntity<Object> getSellerProductsByStatus(@PathVariable("id") String id){
            List<AllUserOrders> allUserOrders = allUserOrdersServices.getSellerProductByStatus(id);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(allUserOrders,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/getReviews", method = RequestMethod.GET)
        public ResponseEntity<Object> getReviews(){
            List<Reviews> reviews = reviewsServices.getReviews();
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(reviews,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/forgetPassword", method = RequestMethod.POST)
        public String processSMS(@RequestBody Sendsms sendsms){
            return smsServices.sendSMS(sendsms.getDestinationSMSNumber());
        }


        @CrossOrigin
        @RequestMapping(value = "/api/getReviewsById/{id}", method = RequestMethod.GET)
        public ResponseEntity<Object> getReviewsbyId(@PathVariable("id") String id){
            List<Reviews> reviews = reviewsServices.GetReviewsById(id);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(reviews,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/Adminlogin", method = RequestMethod.POST)
        public Admin  adminLogin(@RequestBody Admin admin){
            Admin admin1 = adminServices.Validate(admin);
            return admin1;
        }

        @CrossOrigin
        @RequestMapping(value = "/api/addproductRating/{id}", method = RequestMethod.POST)
        public ResponseEntity<Object> addproductRating(@RequestBody Addproduct addproduct,@PathVariable("id") String id){
           Addproduct addproduct1 = addproductServices.StoreRating(id,addproduct);
           return ResponseEntity.ok(addproduct1);
        }

        @CrossOrigin
        @RequestMapping(value = "/api/GetAllCatogory", method = RequestMethod.GET)
        public ResponseEntity<Object> getAllCatogory(){
           List<AddCategoris> categories = addcategoryServices.getCategories();
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(categories,statusCode);
        }
        @CrossOrigin
        @RequestMapping(value = "/api/deleteCategory/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Object> deleteCatogory(@PathVariable("id") String id){
        List<AddCategoris> addCategoris  =  addcategoryServices.deleteCategories(id);
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(addCategoris,statusCode);
        }

    }

