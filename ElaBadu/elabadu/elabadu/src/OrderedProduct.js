import React from "react";
import "./Product.css";

function OrderedProduct({ id, title, image, price, rating }) {
    
    return (
        <div className="orderedProduct">
            <img src={image} alt="" style={{height:200, marginRight:30}}/>

            <div className="product__info">
                <p>{title}</p>
                <p className="product__price">
                    <small>Rs </small>
                    <strong>{price}</strong>
                </p>
                <div className="product__rating">
                    {Array(rating)
                        .fill()
                        .map((_, i) => (
                            <p>🌟</p>
                        ))}
                </div>
            </div>
        </div>
    );
}

export default OrderedProduct;