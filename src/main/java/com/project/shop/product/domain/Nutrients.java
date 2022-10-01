package com.project.shop.product.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("nutrients")
public class Nutrients extends Item {
}
