FROM php:8.3-fpm

# Instalar dependencias
RUN apt-get update && apt-get install -y \
    git \
    unzip \
    libpq-dev \
    && docker-php-ext-install pdo_mysql \
    && curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/bin --filename=composer \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Directorio de trabajo
WORKDIR /var/www/html

# Copiar código
COPY . .

# Instalar Composer (sin --no-dev para que instale todo)
RUN composer install --optimize-autoloader

# Permisos
RUN chown -R www-data:www-data /var/www/html

CMD ["php-fpm"]