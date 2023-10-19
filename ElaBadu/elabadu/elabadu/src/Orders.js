import React, { useEffect, useState } from 'react'
import './Orders.css'
import { useStateValue } from './StateProvider'
import OrderService from './services/OrderService';
import ProductService from './services1/ProductService';
import Product from './Product';
import OrderedProduct from './OrderedProduct';
// import Order from './Order'

const Orders = () => {
    const [{ basket, user }, dispatch] = useStateValue();
    const [orders, setOrders] = useState([]);
    const [orderedItems, setOrderdItems] = useState([])
    const [orderDetails, setOrderDetails] = useState([])
    const [orderedItemsLoaded, setOrderedItemsLoaded] = useState(false)

    useEffect(() => {
        OrderService.getOrdersForCustomer(user?.id).then(res => {
            setOrders(res.data);
            res.data.forEach(order => {
                let arr = [orderedItems]
                OrderService.getOrderDetailsForOrder(order.id).then(res => {
                    setOrderDetails(res.data);
                    // alert(orderDetails)
                    
                    res.data.forEach(orderDetail => {
                        ProductService.getProductById(orderDetail.itemCode).then(res => {
                            arr.push(res.data)
                            setOrderdItems((prev)=>{
                                return prev.concat(res.data)
                            }) 
                        }); 
                    });
                })
            });
        })
    }, [user])

    // useEffect(() => {
    //     if(user) {


    //     db
    //     .collection('users')
    //        .doc(user?.uid)
    //        .collection('orders')
    //        .orderBy('created','desc')
    //        .onSnapshot(snapshot => (
    //            setOrders(snapshot.docs.map(doc => ({
    //             id: doc.id,
    //             data: doc.data()
    //            })))
    //        ))

    //     }
    //     else {
    //         setOrders([])
    //     }

    // }, [user]  )


    return (
        <div className='orders'>
            <h1> Your orders</h1>

            <div className='orders__order'>
                {orderedItems.map(item =>
                    <OrderedProduct
                        id={item.id}
                        title={item.name}
                        price={item.price}
                        rating={item.rating}
                        image={item.imageURL}
                    />
                )}
            </div> 

        </div>
    )

}

export default Orders;