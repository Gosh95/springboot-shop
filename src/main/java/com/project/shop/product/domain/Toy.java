package com.project.shop.product.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("toy")
public class Toy extends Item {
}
